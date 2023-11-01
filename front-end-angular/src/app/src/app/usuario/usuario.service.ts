import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioDTO } from './usuario-dto';
import { Page } from 'src/app/shared/page';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getUsuarios(params?: any): Observable<Page<UsuarioDTO>> {
    return this.http.get<Page<UsuarioDTO>>(`${this.apiUrl}/usuarios`, { params });
  }

  insertUsuario(usuarioDTO: UsuarioDTO): Observable<UsuarioDTO> {
    return this.http.post<UsuarioDTO>(`${this.apiUrl}/usuarios`, usuarioDTO);
  }

  updateUsuario(id: number, usuarioDTO: UsuarioDTO): Observable<UsuarioDTO> {
    return this.http.put<UsuarioDTO>(`${this.apiUrl}/usuarios/${id}`, usuarioDTO);
  }

  deleteUsuario(id: number): Observable<UsuarioDTO> {
    return this.http.delete<UsuarioDTO>(`${this.apiUrl}/usuarios/${id}`);
  }
}
