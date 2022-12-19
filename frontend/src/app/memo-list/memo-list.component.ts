import { Component, OnInit } from '@angular/core';
import {GraphqlService} from "../graphql.service";
import {first} from "rxjs";

@Component({
  selector: 'app-memo-list',
  templateUrl: './memo-list.component.html',
  styleUrls: ['./memo-list.component.css']
})
export class MemoListComponent implements OnInit {

  memoList: Array<any> = [];
  memoFilter = "";

  constructor(private graphqlService: GraphqlService) {
    this.graphqlService.$memoList.subscribe(newList => this.memoList = newList);
  }

  ngOnInit(): void {
    this.graphqlService.getAllMemos();
  }

  onFilterChange(filterValue: string) {
    this.memoFilter = filterValue;
    this.graphqlService.getAllMemos(filterValue);
  }

}
