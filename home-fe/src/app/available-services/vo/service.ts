export class Service {
	
	private _name: string;
	private _displayInfo: string;
	private _url: string;
	
	set name(name: string) {
		this._name = name;
	}
	
	get name(): string {
		return this._name;
	}
	
	set displayInfo(displayInfo: string) {
		this._displayInfo = displayInfo;
	}
	
	get displayInfo(): string {
		return this._displayInfo;
	}
	
	set url(url: string) {
		this._url = url;
	}
	
	get url(): string {
		return this._url;
	}
}