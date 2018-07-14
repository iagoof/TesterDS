import { CurrentProgresses } from './current-progresses';
import { CurrentStages } from './current-stages';

export class User {
	id: number;
	firstname: string;
	lastname: string;
	email: string;
	avatarUrl: string;
	preferredLang: string;
	connected = false;
	creationDate: string;
	birthDay: string;
	currentStages: CurrentStages[];
	currentProgresses: CurrentProgresses[];

	public constructor(data: any = {}) {
		this.id = data.id || '';
		this.firstname = data.firstname || '';
		this.lastname = data.lastname || '';
		this.email = data.email || '';
		this.avatarUrl = data.avatarUrl || '';
		this.preferredLang = data.preferredLang || null;
		this.connected = data.connected || false;
		this.creationDate = data.creationDate || Date.now();
		this.currentStages = data.CurrentStages || new CurrentStages();
		this.currentProgresses = data.CurrentProgresses || new CurrentProgresses();
	}

	public getName() {
		return this.firstname + ' ' + this.lastname;
	}
}
