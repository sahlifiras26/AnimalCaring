import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./Components/home/home.component";
import {ForumsComponent} from "./Components/forums/forums.component";
import {EventtComponent} from "./Components/eventt/eventt.component";
import {DonationComponent} from "./Components/donation/donation.component";
import {AnnouncmentsComponent} from "./Components/announcments/announcments.component";
import {ProfileComponent} from "./Components/profile/profile.component";
import {ArticleComponent} from "./Components/article/article.component";


export const router: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'forum', component: ForumsComponent },

  { path: 'eventt', component: EventtComponent },
  { path: 'donation', component: DonationComponent },
  { path: 'announcment', component: AnnouncmentsComponent },
  { path: 'profile', component: ProfileComponent },

  { path: 'article', component: ArticleComponent },
  { path: '**', redirectTo: 'home' }
];

export const routes: ModuleWithProviders = RouterModule.forRoot( router );
