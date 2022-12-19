import { Component, OnInit } from '@angular/core';
import {GraphqlService} from "../graphql.service";
import {first} from "rxjs";

@Component({
  selector: 'app-create-memo',
  templateUrl: './create-memo.component.html',
  styleUrls: ['./create-memo.component.css']
})
export class CreateMemoComponent implements OnInit {

  memoText = "";

  constructor(private graphqlService: GraphqlService) { }

  ngOnInit(): void {
  }

  onClick() {
    this.graphqlService.createMemo(this.memoText)
      .pipe(first())
      .subscribe({
        next: (result) => {
          this.graphqlService.getAllMemos();
        },
        error: (err) => {
          console.error(err)
        }
      })
  }

}
