import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { first, Observable } from 'rxjs';
import { DataService } from '../data.service';
import { Hero } from '../hero';



@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent implements OnInit {
  heroes: Hero[] = [];
  name: String = "";
  

  constructor(private dataService: DataService,) { }

  ngOnInit(): void {
    this.findAll();
  }
  findAll(): void {
    this.dataService.findAll().subscribe(heroes => this.heroes = heroes)
  }
  create(name: String) {
    this.dataService.create(name).subscribe(hero => this.heroes.push(hero));
  }

  delete(id: number) {
    window.alert("vuoi eliminare?");
    if (confirm("stai per eliminare.sei sicuro?") === true) {
    } else { return }
    const indexToBeRemoved = this.heroes.findIndex((hero) => { return (hero.id === id) });
    console.log(indexToBeRemoved);
    console.log("elimino l'id numero " + id);
    this.heroes.splice(indexToBeRemoved, 1);
    this.dataService.delete(id);
  }

}
 