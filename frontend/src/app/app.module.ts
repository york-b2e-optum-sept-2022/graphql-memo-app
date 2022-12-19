import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';

import {APOLLO_OPTIONS, ApolloModule} from "apollo-angular";
import {HttpLink} from "apollo-angular/http";
import {HttpClientModule} from "@angular/common/http";
import {MemoListComponent} from './memo-list/memo-list.component';
import {InMemoryCache} from "@apollo/client/core";
import { CreateMemoComponent } from './create-memo/create-memo.component';
import {FormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    MemoListComponent,
    CreateMemoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ApolloModule,
    FormsModule
  ],
  providers: [
    {
      provide: APOLLO_OPTIONS,
      useFactory(httpLink: HttpLink) {
        return {
          cache: new InMemoryCache(),
          defaultOptions: {
            mutation: {
              fetchPolicy: 'no-cache',
              errorPolicy: 'all',
            },
            query: {
              fetchPolicy: 'no-cache',
              errorPolicy: 'all',
            }
          },
          link: httpLink.create({
            uri: 'http://localhost:8080/graphql'
          })
        }
      },
      deps: [HttpLink]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
