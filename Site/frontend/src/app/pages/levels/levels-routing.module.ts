import { LevelxComponent } from './levelx.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    data: {
      title: 'Levels'
    },
    children: [
      {
        path: ':id',
        component: LevelxComponent,
        data: {
          title: ':id'
        }
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LevelsRoutingModule { }
