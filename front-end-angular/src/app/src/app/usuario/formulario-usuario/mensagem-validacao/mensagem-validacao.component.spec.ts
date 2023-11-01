import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MensagemValidacaoComponent } from './mensagem-validacao.component';

describe('ValidacaoFormularioComponent', () => {
  let component: MensagemValidacaoComponent;
  let fixture: ComponentFixture<MensagemValidacaoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MensagemValidacaoComponent]
    });
    fixture = TestBed.createComponent(MensagemValidacaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
