import { SubLevel } from './sublevel';

export class Level {
	id: number;
	description: string;
	position: number;
	subLevels: SubLevel[];
}
