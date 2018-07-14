import { ActivatedRoute } from '@angular/router';
import { Component, Input, OnInit, OnDestroy, ViewChild } from '@angular/core';

import { MessagesService, BreadcrumbService, User, UserService } from 'ngx-admin-lte';

import { Level } from './../../models/level';
import { LevelService } from './../../services/level.service';
import { CodeClass } from '../../models/code-class';
import { BsModalComponent } from 'ng2-bs3-modal';


@Component({
	selector: 'app-levelx',
	templateUrl: './levelx.component.html',
	styleUrls: ['./levelx.component.css']
})
export class LevelxComponent implements OnInit, OnDestroy {

	@ViewChild('myModal')
	modal: BsModalComponent;

	private baseCode = new Array<CodeClass>();
	private currentUser: User = new User();
	private currentLevel: Level = new Level();
	private levelId: number;
	private levelsStored = new Array<Level>();
	private sub: any;
	private currentIndex: number;
	private isPrevious: boolean;
	private isNext: boolean;

	constructor(
		private breadService: BreadcrumbService,
		private levelService: LevelService,
		private msgService: MessagesService,
		private route: ActivatedRoute,
		private userService: UserService
	) {
		this.userService.getCurrent().subscribe((user) => {
			this.currentUser = user;
		});

		this.levelService.getStoredLevels().subscribe(levels => {
			this.levelsStored = levels;
		}, (error) => console.log(error), () => console.log(this.levelsStored));
	}

	ngOnInit() {
		// Reading route
		this.sub = this.route.params.subscribe((params) => {
			this.levelId = +params['id'];  // (+) converts string 'id' to a number

			this.setLevelInfo();
			this.updateBreadService();
		});

		// dispatch action to load the details here
	}

	ngOnDestroy() {
		// removing the header
		this.breadService.clear();
		this.sub.unsubscribe();
	}

	close() {
		this.modal.close();
	}

	open() {
		this.modal.open();
	}

	setLevelInfo() {
		this.levelsStored.forEach(level => {
			if (level.id === this.levelId) {
				this.currentLevel = level;
			}
		});
		this.baseCode = this.currentLevel.subLevels[0].baseCode;
		this.currentIndex = 0;
		this.verifyNext();
		this.verifyPrevious();
	}

	updateBreadService() {
		// settings header for the Levelx
		this.breadService.setCurrent({
			description: this.currentLevel.description,
			display: true,
			header: 'Levels',
			levels: [
				{
					icon: 'list-ol',
					link: ['/levels/' + this.levelId],
					title: 'Level ' + this.currentLevel.position
				}
			]
		});
	}

	instrument() {
		this.levelService.instrument(
			this.currentUser.id,
			this.currentLevel.subLevels[0].id,
			this.baseCode);
	}

	verifyNext() {
		this.isNext = (this.currentIndex === this.baseCode.length - 1) ? false : true;
	}

	verifyPrevious() {
		this.isPrevious = (this.currentIndex === 0) ? false : true;
	}

	next() {
		this.currentIndex = this.currentIndex + 1;
		this.verifyNext();
		this.verifyPrevious();
	}

	previous() {
		this.currentIndex = this.currentIndex - 1;
		this.verifyNext();
		this.verifyPrevious();
	}
}
