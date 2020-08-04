import { Component, Input } from '@angular/core';
import { Service } from '../vo/service';

@Component({
	selector: 'app-service-card',
	templateUrl: './service-card.component.html',
	styleUrls: ['./service-card.component.css']
})
export class ServiceCardComponent {

	@Input()
	service: Service;

	isUrlAvailable(): Boolean {
		return this.service && this.service.url && this.service.url.toLowerCase() !== 'no url available';
	}

}
