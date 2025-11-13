import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthRequestDto } from '../../dto/auth-request-dto';
import { AuthService } from '../../service/auth-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login-page',
  imports: [ ReactiveFormsModule, CommonModule ],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css',
})
export class LoginPage implements OnInit {
  protected userForm!: FormGroup;

  constructor(private authService: AuthService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      username: this.formBuilder.control('Valeur', Validators.required),
      password: this.formBuilder.control('',[Validators.required, Validators.minLength(6)])
    });
  }

  public connecter() {
    this.authService.auth(new AuthRequestDto(this.userForm.value.username, this.userForm.value.password));
  }
}
