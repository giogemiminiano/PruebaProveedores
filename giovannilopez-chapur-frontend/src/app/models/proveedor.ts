export interface Proveedor {
    id: string;
    name: string;
    country: string;
}


export interface ProveedorResponse {
  content: Proveedor[];
  page: number;
  size: number;
  totalElements: number;
  totalPage: number;
}