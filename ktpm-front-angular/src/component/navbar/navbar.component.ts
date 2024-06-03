import { Component, ViewChild } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  onSearchClick(): void {
    // Handle search click event here
    console.log('Search clicked!');
  }
  
}
