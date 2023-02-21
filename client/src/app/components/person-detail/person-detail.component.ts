import {Component, Input} from '@angular/core';
import {Person} from "../../models/Person";

@Component({
  selector: 'app-person-detail',
  templateUrl: './person-detail.component.html',
  styleUrls: ['./person-detail.component.scss']
})
export class PersonDetailComponent {
  @Input()
  person?: Person | null;
}
