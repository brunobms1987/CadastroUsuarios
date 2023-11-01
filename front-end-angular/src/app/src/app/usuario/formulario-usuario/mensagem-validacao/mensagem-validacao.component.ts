import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-mensagem-validacao',
  templateUrl: './mensagem-validacao.component.html',
  styleUrls: ['./mensagem-validacao.component.scss']
})
export class MensagemValidacaoComponent {

  @Input() form: FormGroup | null = null;

  @Input() campo: string = '';

  @Input() parametro?: {
    minlength?: number,
    maxlength?: number;
  }

  nomeCampo(): string {
    return this.campo.charAt(0).toUpperCase() + this.campo.slice(1);
  }


  ehValorInvalido(): boolean | undefined {
    return this.campo?.length > 0 && this.form?.controls[this.campo]?.invalid;
  }

  ehCampoModificado(): boolean | undefined {
    return this.campo?.length > 0 && (this.form?.controls[this.campo]?.dirty || this.form?.controls[this.campo]?.touched);
  }

  ehErro(tipoErro: string) {
    return this.form?.controls[this.campo].hasError(tipoErro);
  }

  ehErroConfirmacaoSenha(tipoErro: string) {
    return this.form?.hasError(tipoErro);
  }

}
