import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, map, Observable} from "rxjs";
import {PeopleResponse} from "../models/PeopleResponse";

@Injectable({
  providedIn: 'root'
})
export class PeopleService {
  // URL to api
  private url = 'https://swapi-production-ec5a.up.railway.app/people/';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(
    private http: HttpClient) {
  }

  /**
   * Get the people from the api
   * @param searchTerm String to search through the people
   * @param page PageNumber
   */
  getPeople(searchTerm = "", page = 1): Observable<PeopleResponse> {
    return this.http.get<PeopleResponse>(this.url + `?search=${searchTerm}&page=${page}`)
      .pipe(
        map(res => res as PeopleResponse),
        catchError((err) => [])
      );
  }
}
