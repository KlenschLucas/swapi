import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-pagination',
  templateUrl: './pagination.component.html',
  styleUrls: ['./pagination.component.scss']
})
export class PaginationComponent {
  @Input() currentPage = 1;
  @Input() hasNextPage: boolean = true;
  @Input() hasPreviousPage: boolean = true;

  @Output() pageChanged = new EventEmitter<number>();

  /**
   * Click event that emits an event when changing the page number
   * @param pageNumber
   */
  changePage(pageNumber: number) {
    this.pageChanged.emit(pageNumber);
  }
}
