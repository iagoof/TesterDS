import { Component, OnInit, OnDestroy } from '@angular/core';
import { BreadcrumbService, Message, MessagesService } from 'ngx-admin-lte';

@Component({
	selector: 'app-home',
	styleUrls: ['./home.component.css'],
	templateUrl: './home.component.html'
})
export class HomeComponent implements OnInit, OnDestroy {
	public date: Date = new Date();

	constructor(
		private breadServ: BreadcrumbService,
		private msgServ: MessagesService,
	) {

	}

	public ngOnInit() {
		// setttings the header for the home
		this.breadServ.setCurrent({
			description: 'HomePage',
			display: true,
			header: 'Dashboard',
			levels: [
				{
					icon: 'dashboard',
					link: ['/'],
					title: 'Home'
				}
			]
		});

	}

	public ngOnDestroy() {
		// removing the header
		this.breadServ.clear();
	}

}
