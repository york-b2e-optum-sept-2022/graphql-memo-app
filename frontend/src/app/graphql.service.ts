import { Injectable } from '@angular/core';
import {BehaviorSubject, first, Observable} from "rxjs";
import {Apollo, gql} from "apollo-angular";


enum NewMemo {
  text
}

@Injectable({
  providedIn: 'root'
})
export class GraphqlService {

  $memoList = new BehaviorSubject<any>([]);

  constructor(private apollo: Apollo) { }

  getAllMemos(filterText?: String): void{

    let query = gql`
      query {
        memoList {
          text
        }
      }
    `;

    if (filterText) {
      query = gql`
        query getFilteredMemos($filter: String!){
          memoList(filter: {text: $filter}) {
            text
          }
        }
      `;
    }

    this.apollo.query(
      {
        query: query,
        variables: {
          filter: filterText
        }
      }
    ).pipe(first()).subscribe({
      next: (result: any) => {
        this.$memoList.next(result?.data?.memoList)
      },
      error: (err) => {
        console.error(err);
      }
    })
  }

  createMemo(textFromInput: string): Observable<any> {
    return this.apollo.mutate(
      {
        mutation: gql`
            mutation createMemo($memo: NewMemo!){
              createMemo(memo: $memo) {
                id
              }
            }
        `,
        variables: {
          memo: {text: textFromInput}
        }
      }
    )
  }


}
