import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {ForumService} from "./Services/forum.service";
import {HttpModule} from "@angular/http";
import {DataService} from "./Services/data.service";
import {ForumsComponent} from "./Components/forums/forums.component";
import {ForumComponent} from "./Components/forums/forum/forum.component";
import {DiscussionComponent} from "./Components/forums/forum/discussion/discussion.component";
import { HomeComponent } from './Components/home/home.component';
import {routes} from "./routing";
import { EventtComponent } from './Components/eventt/eventt.component';
import { DonationComponent } from './Components/donation/donation.component';
import { ProfileComponent } from './Components/profile/profile.component';
import { AnnouncmentsComponent } from './Components/announcments/announcments.component';
import { ArticleComponent } from './Components/article/article.component';

@NgModule({
  declarations: [
    AppComponent,
    ForumsComponent,
    ForumComponent,
    DiscussionComponent,
    HomeComponent,
    EventtComponent,
    DonationComponent,
    ProfileComponent,
    AnnouncmentsComponent,
    ArticleComponent
  ],
  imports: [
    BrowserModule,HttpModule
  ,routes
  ],
  providers: [ForumService,DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
