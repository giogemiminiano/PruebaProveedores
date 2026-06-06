import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Proveedor } from './models/proveedor';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  proveedorArray: Proveedor[]=[
    {id:"1",name:"Tom",country:"MX",active:true},
    {id:"2",name:"Jhon",country:"MX",active:true}
  ];
  selectedProveedor: Proveedor = {
  id: '',
  name: '',
  country: '',
  active: false
  };

  addProveedor(): void{
    this.selectedProveedor.id = "" + this.proveedorArray.length+1;
    this.proveedorArray.push(this.selectedProveedor);
    this.selectedProveedor = {
    id: '',
    name: '',
    country: '',
    active: false
    };
  }

  updateProveedor(proveedor:Proveedor) : void{
    this.selectedProveedor = { ...proveedor };
  }

  deleteProveedor(id: string): void {
    if (confirm('¿Deseas eliminar este proveedor?')) {
      this.proveedorArray = this.proveedorArray.filter(
        p => p.id !== id
      );
    }
  }
}
