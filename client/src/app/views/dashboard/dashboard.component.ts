import {Component, OnInit} from '@angular/core';
import {PeopleService} from "../../services/people.service";
import {BehaviorSubject, Observable, Subject, tap} from "rxjs";
import {PeopleResponse} from "../../models/PeopleResponse";
import {Person} from "../../models/Person";
import {debounceTime} from 'rxjs/operators';
import {FormControl} from "@angular/forms";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  peopleResponse: PeopleResponse | null = null;

  loading: boolean = true;
  searchInput$ = new BehaviorSubject<string>("");

  currentPage: number = 1;
  viewPersonDetails: Person | null = null;

  constructor(private peopleService: PeopleService) {}

  ngOnInit() {
    this.searchInput$
      .pipe(debounceTime(500))
      .subscribe((query: string) => {
        this.loading = true;
        this.peopleService.getPeople(query)
          .subscribe(data => {
            this.peopleResponse = data;
            this.loading = false;
          });
      });
  }

  /**
   * Bind to input event
   * @param event
   */
  onSearch(event: Event) {
    const target = event.target as HTMLInputElement;
    this.currentPage = 1;
    this.searchInput$.next(target.value);
  }

  /**
   * Change the Page Number we are viewing
   * @param page
   */
  public changePage(page: number) {
    this.currentPage = page;
    this.loading = true;
    this.peopleService.getPeople(this.searchInput$.value, page)
      .subscribe(data => {
        console.log(this.peopleResponse)
        this.peopleResponse = data;
        this.loading = false;
      });
  }

  /**
   * Set the details of the person we trying to view
   * @param person
   */
  public viewDetails(person: Person | null) {
    this.viewPersonDetails = person;
  }

  /**
   * Show the home screen
   */
  public viewHome() {
    this.viewPersonDetails = null;
  }

}
