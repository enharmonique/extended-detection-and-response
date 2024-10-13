import {Component, DestroyRef, inject} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {Router} from "@angular/router";
import {catchError, EMPTY, tap} from "rxjs";
import {takeUntilDestroyed} from "@angular/core/rxjs-interop";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  private readonly authService = inject(AuthService);
  private readonly router = inject(Router);
  private readonly destroyRef = inject(DestroyRef);


  public username: string = '';
  public password: string = '';
  public confirmPassword: string = '';
  public errorMessage: string = '';
  public successMessage: string = '';

  public onSubmit(): void {
    if (this.password !== this.confirmPassword) {
      this.errorMessage = 'Passwords do not match';
      return;
    }

    this.authService.register({
      username: this.username, password: this.password})
      .pipe(
        tap(() => this.router.navigate(['/login'])),
        catchError(() => {
          this.errorMessage = 'Please try again';
          return EMPTY;
        }),
        takeUntilDestroyed(this.destroyRef),
      )
      .subscribe();
  }
}
