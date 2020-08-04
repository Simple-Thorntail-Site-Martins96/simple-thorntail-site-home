import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest-service';
import { CookieService } from 'ngx-cookie-service';
import { host, loginUrl } from '../../environments/environment';
import { Subscription } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Service } from './vo/service';

const servicesUrl: string = "http://" + host + "/api/home/services";

@Component({
	selector: 'app-available-services',
	templateUrl: './available-services.component.html',
	styleUrls: ['./available-services.component.css']
})
export class AvailableServicesComponent implements OnInit {
	
	private jwt: string;
	private sub: Subscription;
	
	services: Service[];
	
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
		
		this.sub = this.rest.sendGet<Service[]>(servicesUrl, headers)
		.subscribe(resp => {
			this.services = resp.body;
		}, error => {
			if (error.status === 401) {
				console.error('Not authorized, redirect to login', error);
				window.location.href = loginUrl;
			} else {
				console.error('Error in service call, loading empty', error);
				this.services = new Service[0];
			}
		});
	}

}
