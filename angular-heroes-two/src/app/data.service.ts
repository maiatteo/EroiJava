import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Hero } from './hero';


@Injectable({
  providedIn: 'root'
})
export class DataService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) { }
  private heroesUrl = "http://127.0.0.1:8080/api/heroes/"
  findAll(): Observable<Hero[]> {
    return this.http.get("http://localhost:8080/api/heroes/all") as Observable<Hero[]>;

  }
  create(hero: String): Observable<Hero> {
    return this.http.post("http://localhost:8080/api/heroes/create", hero) as Observable<Hero>;
  }
  delete(id: number) {
    this.http.post(this.heroesUrl + 'delete/' + id, "").subscribe();
  }
  update(hero: Hero, name : String): Observable<any>  {
   let heroUpdated : Hero = {id : hero.id, name : name}
   return  this.http.post(this.heroesUrl + "update",heroUpdated, this.httpOptions).pipe(tap(_ =>console.log("eroe aggiornato " + hero.name)))
  }
  getHero(id: number): Observable<Hero> {
    return this.http.get(this.heroesUrl + id) as Observable<Hero>;
  }
}

