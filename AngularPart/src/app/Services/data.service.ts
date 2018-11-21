import { Injectable } from '@angular/core';
import {Http} from '@angular/http';
import 'rxjs/add/operator/map';
@Injectable()
export class DataService {

  constructor(private url: string, private http: Http) { }
  getAll() {
    return this.http.get(this.url).map(response => response.json());
  }
  create(ressource) {
    return this.http.post(this.url, JSON.stringify(ressource)).map(response => response.json());
  }
  // use put instead,patch just gives server one ressource
  update(ressource) {
    return this.http.put(this.url + '/' + ressource.id, ressource).map(response => response.json());
  }
  delete(ressource) {
    return this.http.delete(this.url + '/' + ressource.id).map(response => response.json());
  }
}
