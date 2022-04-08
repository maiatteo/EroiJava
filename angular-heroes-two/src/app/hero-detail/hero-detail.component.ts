import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';
import { Hero } from '../hero';
import { Location } from '@angular/common';
@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {
  hero: Hero | undefined;
  constructor(private route: ActivatedRoute,
    private dataService : DataService,
    private location: Location) { }

  ngOnInit(): void {
    this.getHero();
  }
  goBack(): void {
    this.location.back();
  }
  getHero(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.dataService.getHero(id)
      .subscribe(hero => this.hero = hero);
  }
  update(name : String) : void {
    if(this.hero){
    console.log("aggiornato eroe " + name);
    this.dataService.update(this.hero, name)
    .subscribe(()=> this.goBack());
  }
}
}
