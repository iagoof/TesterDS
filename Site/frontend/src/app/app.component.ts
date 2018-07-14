import { LevelNav } from './models/level-nav';
import { LevelService } from './services/level.service';
import { Component, OnInit } from '@angular/core';
import {
	User,
	MenuService,
	Message,
	MessagesService,
	NotificationsService,
	Notification,
	LogoService,
	FooterService
} from 'ngx-admin-lte';
import { MenuWidgetComponent } from './widgets/menu-widget/menu-widget.component';
import { Level } from './models/level';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

	private levelsNav: LevelNav[];
	private levels = new Array<Level>();

	// define your footer links
	private footer = {
		left_part: `<strong>
        Copyright &copy; 2017
        <a href="http://www.ufjf.br/ufjf/" >UFJF</a>.
      </strong>
      Sharing Knowledge`,
		right_part: 'TesterDS',
	};
	// define here your own links menu structure
	private mylinks: any = [
		{
			'header': 'NAVIGATION TITLE'
		},
		{
			'title': 'Home',
			'icon': 'dashboard',
			'link': ['/']
		},
		{
			'title': 'Levels',
			'icon': 'list-ol',
			'sublinks': [
			]
		},
		{
			'title': 'Documentation',
			'icon': 'book',
			'sublinks': [
				{
					'title': 'Github',
					'link': ['#'],
					'icon': 'github',
					'external': true,
					'target': '_blank'
				},
				{
					'title': 'Yahoo',
					'link': ['#'],
					'icon': 'yahoo',
					'external': true,
					'target': '_blank'
				}
			]
		}
	];
	// define here your logo
	private logo = {
		html_mini: '<b>T</b>DS',
		html_lg: '<b>TESTER</b>DS',
	};

	constructor(
		private footerServ: FooterService,
		private menuServ: MenuService,
		private logoServ: LogoService,
		private msgServ: MessagesService,
		private notifServ: NotificationsService,
		private levelService: LevelService
	) {

		// Get levels nav to sidebar
		levelService.getLevelsNav().subscribe(result => {
			this.levelsNav = result;
			this.mylinks[2].sublinks = this.levelsNav;
		});
	}

	public ngOnInit() {
		// define menu
		this.menuServ.setCurrent(this.mylinks);

		this.footerServ.setCurrent(this.footer);
		this.logoServ.setCurrent(this.logo);

		// FAKE MESSAGE
		// defining some test users
		const user1 = new User({
			avatarUrl: 'assets/img/user2-160x160.jpg',
			email: 'john.doe.pro@gmail.com',
			firstname: 'JOHN',
			lastname: 'Doe'
		});
		const user2 = new User({
			avatarUrl: 'assets/img/user2-160x160.jpg',
			email: 'EMAIL',
			firstname: 'FIRSTNAME',
			lastname: 'LASTNAME'
		});
		// sending a test message
		this.msgServ.addMessage(new Message({
			author: user2,
			content: 'a new sublevel available',
			destination: user1,
			title: `there's news in the game!`
		}));
		// sending a test notif
		this.notifServ.addNotification(new Notification({
			class: 'fa fa-users text-aqua',
			content: '5 new members joined today',
			link: '/page/2'
		}));


	}

}
