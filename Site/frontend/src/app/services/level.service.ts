import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http/';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';
import { API_URL } from './../utils/app-api';
import { Level } from './../models/level';
import { LevelNav } from './../models/level-nav';
import { HttpHeaders } from '@angular/common/http';
import { CodeClass } from '../models/code-class';
import { ReplaySubject } from 'rxjs';


@Injectable()
export class LevelService {

	private levels: ReplaySubject<Level[]> = new ReplaySubject<Level[]>(1);

	getLevels(userId: number): Observable<Level[]> {
		return this.http.get<Level[]>(`${API_URL}/levels/${userId}/currents`);
	}

	getLevelsNav(): Observable<LevelNav[]> {

		return this.http.get<LevelNav[]>('http://localhost:8080/levels/nav', {
			headers: new HttpHeaders().set('Content-Type', 'application/json')
				.set('Accept', 'application/json')
				.set('Access-Control-Allow-Headers', 'Content-Type')
		});
	}

	public storelevels(levels: Level[]) {
		this.levels.next(levels);
	}

	public getStoredLevels() {
		return this.levels;
	}

	public instrument(userId: number, subLevelId: number, baseCode: CodeClass[] ) {
		console.log('Implementar Instrumentação');
	}

	constructor(
		private http: HttpClient,
		private router: Router) { }
}
