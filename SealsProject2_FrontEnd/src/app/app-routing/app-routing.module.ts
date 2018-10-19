import { Routes } from '@angular/router'
import { LoginComponent } from '../components/login/login.component';
import { DashboardComponent } from '../components/dashboard/dashboard.component';
import { GetterComponent } from '../components/getter/getter.component';
import { QuestionformComponent } from '../components/questionform/questionform.component';
import { QuizzieComponent } from '../components/quizzie/quizzie.component';
import { CreateUserComponent } from '../components/create-user/create-user.component';
import { UpdateInfoComponent } from '../components/update-info/update-info.component';
import { TakeQuizComponent } from '../components/take-quiz/take-quiz.component';
import { ViewStatsComponent } from '../components/view-stats/view-stats.component';
import { DefaultComponent } from '../components/default/default.component';
import { LoggedInComponent } from '../components/logged-in/logged-in.component';
import { UserQuizzieComponent } from '../components/user-quizzie/user-quizzie.component';
import { QuizzieSessionComponent } from '../components/quizzie-session/quizzie-session.component';

export const routes: Routes = [ {

  path: 'login',
  component: LoginComponent
}, {
  path: 'dashboard',
  component: DashboardComponent
}, {
  path: 'get' , 
  component: GetterComponent
}, {
  path: 'questionform' ,
  component: QuestionformComponent
}, {
  path: 'quizzie' ,
  component: QuizzieComponent
},{
  path: 'createUser' ,
  component: CreateUserComponent
},{
  path: 'updateInfo' ,
  component: UpdateInfoComponent
},{
  path: 'takeQuiz' ,
  component: TakeQuizComponent
},{
  path: 'viewStats' ,
  component: ViewStatsComponent
},{
  path: 'default' ,
  component: DefaultComponent
},{
  path: 'loggedIn' ,
  component: LoggedInComponent
},{
  path: 'userQuizzie' ,
  component: UserQuizzieComponent
}, {
  path: 'savedQuizzie',
  component: QuizzieSessionComponent  

},{
  path: '**',
  pathMatch: 'full',
  redirectTo: ''
}];
//export class AppRoutingModule { }
