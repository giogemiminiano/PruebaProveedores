import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ProveedorService } from './services/proveedor.service';
import { Proveedor } from './models/proveedor';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  proveedorArray: Proveedor[]=[];

  page = 0;
  size = 10;
  totalPages = 0;
  totalElements = 0;

  selectedProveedor: Proveedor = {
  id: '',
  name: '',
  country: ''
  };

  constructor(private proveedorService: ProveedorService) {}

  ngOnInit(): void {
    this.getProveedores();
  }

  getProveedores(): void {
  this.proveedorService.getAll(this.page,this.size).subscribe({
    next: (response) => {
      this.proveedorArray = response.content;
      this.totalPages = response.totalPage;
      this.totalElements = response.totalElements;
    },
    error: (err) => {
      console.error(err);
    }
  });
}

   createOrUpdateProveedor(): void {
    if(this.selectedProveedor.id!==''){
      this.saveUpdate();
    }else{
      this.proveedorService.create(this.selectedProveedor).subscribe(() => {
      this.getProveedores();
      this.selectedProveedor = { id:'', name: '', country: '' };
    });
    }
    
  }

  updateProveedor(proveedor: Proveedor): void {
    this.selectedProveedor = { ...proveedor };
  }

  deleteProveedor(id: string): void {
    if (confirm('¿Deseas eliminar este proveedor?')) {
      this.proveedorService
        .delete(id)
        .subscribe(() => {
          this.getProveedores();
          this.selectedProveedor = {id:'', name: '', country: '' };
        });
    }
  }

  saveUpdate(): void {
    if (this.selectedProveedor.id) {
      this.proveedorService
        .update(this.selectedProveedor.id, this.selectedProveedor)
        .subscribe(() => {
          this.getProveedores();
          this.selectedProveedor = {id:'', name: '', country: '' };
        });
    }
  }

  nextPage(): void {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.getProveedores();
    }
  }

  previousPage(): void {
    if (this.page > 0) {
      this.page--;
      this.getProveedores();
    }
  }
}
