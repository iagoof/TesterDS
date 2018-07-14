import { UserApiService } from './services/user-api.service';
import { LevelxComponent } from './pages/levels/levelx.component';
import { LevelService } from './services/level.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

// components
import { AppComponent } from './app.component';

// modules
import { NgxAdminLteModule, UserService } from 'ngx-admin-lte';

// les pages
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';

const pages = [
	HomeComponent,
	LoginComponent,
	RegisterComponent
];

// main bootstrap
import { routing } from './app.routes';
import { MenuWidgetComponent } from './widgets/menu-widget/menu-widget.component';
import { HeaderWidgetComponent } from './widgets/header-widget/header-widget.component';

import { BsModalModule } from 'ng2-bs3-modal';

@NgModule({
	declarations: [
		AppComponent,
		...pages,
		MenuWidgetComponent,
		HeaderWidgetComponent,
		LevelxComponent
	],
	imports: [
		BrowserModule,
		BsModalModule,
		FormsModule,
		ReactiveFormsModule,
		HttpModule,
		NgxAdminLteModule,
		routing
	],
	providers: [
		LevelService,
		UserService,
		UserApiService
	],
	bootstrap: [
		AppComponent
	],
	entryComponents: [
		MenuWidgetComponent,
		HeaderWidgetComponent
	]
})
export class AppModule { }
