import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component } from '@angular/core';
import { GameService } from 'src/app/services/game.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-game-form',
  templateUrl: './game-form.component.html',
  styleUrls: ['./game-form.component.css']
})
export class GameFormComponent {

  formGroup: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private gameService: GameService,
    private router: Router) {
    this.formGroup = formBuilder.group({
    nome:['', Validators.required],
    plataforma:['', Validators.required]
    })
  }

  onSubmit() {
    if (this.formGroup.valid) {
      const novoGame = this.formGroup.value;
      this.gameService.salvar(novoGame).subscribe({
        next: (gameCadastrado) => {
          this.router.navigateByUrl('/games/list');
        },
        error: (err) => {
          console.log('Erro ao salvar' + JSON.stringify(err));
        }
      })

    }
  }
}
