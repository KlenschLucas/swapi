import {Component, EventEmitter, Input, Output} from '@angular/core';
import {Person} from "../../models/Person";

@Component({
  selector: 'app-person-card',
  templateUrl: './person-card.component.html',
  styleUrls: ['./person-card.component.scss']
})
export class PersonCardComponent {
  @Input() people?: Person[] = [];
  @Output() viewPersonDetails = new EventEmitter<Person>();

  /**
   * Click event to show person details
   */
  viewDetails(person: Person) {
    this.viewPersonDetails.emit(person);
  }
}
