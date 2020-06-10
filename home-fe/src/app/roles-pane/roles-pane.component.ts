import { Component, OnInit, OnDestroy } from '@angular/core';
import { RestService } from '../rest-service';
import { CookieService } from 'ngx-cookie-service';
import { Subscription } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { host } from '../../environments/environment';
import { loginUrl } from '../../environments/environment';

const rolesUrl = 'http://' + host + '/api/home/role';

@Component({
	selector: 'app-roles-pane',
	templateUrl: './roles-pane.component.html',
	styleUrls: ['./roles-pane.component.css']
})
export class RolesPaneComponent implements OnInit {

	private jwt: string;
	private sub: Subscription;
	
	roles: string[];
	
	constructor(private rest: RestService, cookies: CookieService) { 
		this.jwt = cookies.get('user.jwt');
	}

	ngOnInit(): void {
		if (this.sub)
			this.sub.unsubscribe();
		
		let headers: HttpHeaders = new HttpHeaders({
			'Accept': 'application/json',
			'Authorization': ('Bearer ' + this.jwt)
		});
		this.sub = this.rest.sendGet(rolesUrl, headers)
		.subscribe(resp => {
			console.log(resp.body);
			this.roles = resp.body.roles;
		}, error => {
			if (error.status === 401) {
				console.error('Not authorized. ', error);
				window.location.href = loginUrl;
			} else {
				console.error(error);
			}
		})
	}

	ngOnDestroy(): void {
		if(this.sub)
			this.sub.unsubscribe();
	}
	
}
