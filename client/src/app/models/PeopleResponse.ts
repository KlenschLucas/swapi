import {Person} from "./Person";

export interface PeopleResponse {
  next: string;
  previous: string;
  count: number;
  results: Person[];
}
