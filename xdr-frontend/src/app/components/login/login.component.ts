import {Component, DestroyRef, inject} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";
import {catchError, EMPTY, tap} from "rxjs";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  private readonly authService = inject(AuthService);
  private readonly router = inject(Router);
  private readonly destroyRef = inject(DestroyRef);

  public username: string = '';
  public password: string = '';
  public errorMessage: string = '';

  public onSubmit(): void {
    this.authService.login({
      username: this.username, password: this.password})
      .pipe(
        tap(() => this.router.navigate(['/home'])),
        catchError(() => {
          this.errorMessage = 'Invalid username or password';
          return EMPTY;
        }),
        takeUntilDestroyed(this.destroyRef),
      )
      .subscribe();
  }
}
