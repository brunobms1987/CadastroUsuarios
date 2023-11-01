import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioComponent } from './src/app/usuario/usuario.component';
import { TabelaUsuarioComponent } from './src/app/usuario/tabela-usuario/tabela-usuario.component';
import { FormularioUsuarioComponent } from './src/app/usuario/formulario-usuario/formulario-usuario.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MensagemValidacaoComponent } from './src/app/usuario/formulario-usuario/mensagem-validacao/mensagem-validacao.component';
import { HttpClientModule } from '@angular/common/http';
import { UsuarioService } from './src/app/usuario/usuario.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioComponent,
    FormularioUsuarioComponent,
    TabelaUsuarioComponent,
    MensagemValidacaoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSnackBarModule,
    MatTableModule,
    MatPaginatorModule
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
