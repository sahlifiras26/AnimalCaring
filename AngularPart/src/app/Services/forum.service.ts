import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
import {DataService} from "./data.service";

@Injectable()
export class ForumService extends DataService{
  constructor(http: Http) {
    super('http://localhost:18080/piac-web/pi/forums',http);
  }


}
