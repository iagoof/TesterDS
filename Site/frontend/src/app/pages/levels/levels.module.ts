import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LevelsRoutingModule } from './levels-routing.module';
import { LevelsComponent } from './levels.component';
import { LevelxComponent } from './levelx.component';

@NgModule({
  imports: [
    CommonModule,
    LevelsRoutingModule
  ],
  declarations: [LevelsComponent, LevelxComponent]
})
export class LevelsModule { }
