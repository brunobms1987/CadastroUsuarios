import { Component, OnInit, ViewChild } from '@angular/core';
import { UsuarioService } from './usuario.service';
import { UsuarioDTO } from './usuario-dto';
import { Page } from 'src/app/shared/page';
import { TabelaUsuarioComponent } from './tabela-usuario/tabela-usuario.component';

@Component({
  selector: 'cadastro-usuarios',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.scss']
})
export class UsuarioComponent implements OnInit {

  @ViewChild('tabelaUsuario') tabelaUsuario!: TabelaUsuarioComponent;

  constructor(private usuarioSerivce: UsuarioService) {
  }

  ngOnInit() {
    this.getUsuarios();
  }

  private getUsuarios(params?: any) {
    this.usuarioSerivce.getUsuarios(params).subscribe((response: Page<UsuarioDTO>) => {
        this.tabelaUsuario.setDadosUsuarios(response);
    })
  }

  private criarPaginacao() {
    return {
      page: '0',
      size: '5',
    };
  }

  reloadTabelaEvent(event: boolean) {
    if (event) {
      this.getUsuarios(this.criarPaginacao())
    }
  }
}
