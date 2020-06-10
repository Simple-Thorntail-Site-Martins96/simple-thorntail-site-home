import { Component, OnInit, OnDestroy } from '@angular/core';
import { host } from '../../environments/environment'
import { RestService } from '../rest-service';
import { HttpHeaders } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { loginUrl } from '../../environments/environment';
import { Subscription } from 'rxjs';

const nameUrl: string = 'http://' + host + '/api/home/name';

@Component({
	selector: 'app-name-pane',
	templateUrl: './name-pane.component.html',
	styleUrls: ['./name-pane.component.css']
})
export class NamePaneComponent implements OnInit {

	private jwt: string;
	name: string;
	
	private sub: Subscription;

	constructor(private rest: RestService, cookies: CookieService) { 
		this.jwt = cookies.get('user.jwt');
	}

	ngOnInit(): void {
		if (this.sub)
			this.sub.unsubscribe();
		
		let headers: HttpHeaders = new HttpHeaders({
			'Accept': 'text/plain',
			'Authorization': ('Bearer ' + this.jwt)
		});
		this.sub = this.rest.sendGetRow(nameUrl, headers)
			.subscribe(resp => {
				console.log('Ok name is --> ' + resp.body)
				this.name = resp.body;
			}, error => {
				if (error.status === 401) {
					console.error('Call error, not authorized, go to login', error)
					window.location.href = loginUrl;
				} else {
					console.error('Error in home call: ', error)
					this.name = error.body;
				}
			});
	}
	
	ngOnDestroy(): void {
		if(this.sub)
			this.sub.unsubscribe();
	}

}
