import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabelaUsuarioComponent } from './tabela-usuario.component';

describe('TabelaUsuarioComponent', () => {
  let component: TabelaUsuarioComponent;
  let fixture: ComponentFixture<TabelaUsuarioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TabelaUsuarioComponent]
    });
    fixture = TestBed.createComponent(TabelaUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
