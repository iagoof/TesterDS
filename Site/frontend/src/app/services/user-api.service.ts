import { API_URL } from './../utils/app-api';
import { HttpClient, HttpHeaders } from '@angular/common/http/';
import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { User } from 'ngx-admin-lte';

@Injectable()
export class UserApiService {

	constructor(private http: HttpClient) { }

	getUser(email: string, password: string): Observable<User> {
		const url = `${API_URL}/users/login/${email}/${password}/`;
		return this.http.get<User>(url, {
			headers: new HttpHeaders().set('Content-Type', 'application/json')
				.set('Accept', 'application/json')
				.set('Access-Control-Allow-Headers', 'Content-Type')
		});
	}

}
