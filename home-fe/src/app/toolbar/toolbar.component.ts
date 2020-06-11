import { Component } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';

import { loginUrl } from '../../environments/environment';

@Component({
	selector: 'app-toolbar',
	templateUrl: './toolbar.component.html',
	styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {

	constructor(private cookies: CookieService) { }


	logout(): void {
		this.cookies.delete('user.jwt');
		window.location.href = loginUrl;
	}

}
