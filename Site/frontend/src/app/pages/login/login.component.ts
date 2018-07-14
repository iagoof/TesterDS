import { LevelService } from './../../services/level.service';
import { UserApiService } from './../../services/user-api.service';
import { Component, OnInit, OnDestroy } from '@angular/core';
import { User, UserService } from 'ngx-admin-lte';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
	selector: 'app-login',
	styles: ['./login.css'],
	templateUrl: './login.component.html'
})
export class LoginComponent implements OnInit {

	public email: string;
	private errorMessage: string;
	private levels: any;
	public loginError = false;
	private loginForm: FormGroup;
	public password: string;
	public user: User;

	constructor(
		private fb: FormBuilder,
		private router: Router,
		private userApiService: UserApiService,
		private levelService: LevelService,
		private userServ: UserService
	) {
		this.errorMessage = '';
	}

	public ngOnInit() {
		window.dispatchEvent(new Event('resize'));

		this.loginForm = this.fb.group({
			email: this.fb.control('', [Validators.required, Validators.minLength(4)]),
			password: this.fb.control('', [Validators.required, Validators.minLength(6)])
		});
	}

	getLevels(userId: number) {
		this.levelService.getLevels(userId).subscribe(
			data => {
				this.levels = data;
				this.levelService.storelevels(this.levels);
			},
			(error) => {
				console.log('Error: ', error);
			});
	}


	private login() {
		this.loginError = false;
		this.userApiService.getUser(this.loginForm.value.email, this.loginForm.value.password)
			.subscribe(
			(data) => {
				this.user = new User(data);
				this.user.connected = true;
				this.userServ.setCurrent(this.user);
				this.errorMessage = '';
			},
			(error) => {
				this.errorMessage = 'Error: ';
				this.loginError = true;
				switch (error.status) {
					case 401: this.errorMessage += 'Password is wrong!'; break;
					case 404: this.errorMessage += 'Email not found!'; break;
					default: this.errorMessage += 'Could not communicate with the server. Please try again later.';
				}
			},
			() => {
				console.log('Error: ', this.errorMessage);
				this.getLevels(this.user.id);
				this.router.navigate(['home']);
			}
			);
	}

}
