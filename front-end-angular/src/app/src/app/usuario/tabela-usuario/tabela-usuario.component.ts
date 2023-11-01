import { Component, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { UsuarioDTO } from '../usuario-dto';
import { Page } from 'src/app/shared/page';

@Component({
  selector: 'app-tabela-usuario',
  templateUrl: './tabela-usuario.component.html',
  styleUrls: ['./tabela-usuario.component.scss']
})
export class TabelaUsuarioComponent {

  dataSource: MatTableDataSource<UsuarioDTO> = new MatTableDataSource();
  displayedColumns: string[] = ['id', 'nome', 'email'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  @Input()
  setDadosUsuarios(usuarios: Page<UsuarioDTO>) {
    this.dataSource = new MatTableDataSource<UsuarioDTO>(usuarios.content);
    this.dataSource.paginator = this.paginator;
  }

  constructor() {}

}