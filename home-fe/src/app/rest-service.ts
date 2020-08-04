import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
	providedIn: 'root'
})
export class RestService {

	constructor(private http: HttpClient) { }

	sendGetRow(url: string, headers: HttpHeaders): Observable<HttpResponse<string>> {
		return this.http.get(url, {
			headers,
			observe: 'response',
			responseType: 'text'
		});
	}

	sendGet<T>(url: string, headers: HttpHeaders): Observable<HttpResponse<T>> {
		return this.http.get<T>(url, {
			headers,
			observe: 'response'
		});
	}
}
