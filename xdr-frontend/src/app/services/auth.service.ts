import {inject, Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private readonly baseUrl = 'http://localhost:8080/xdr';
  private readonly http = inject(HttpClient);

  login(user: { username: string, password: string }): Observable<User> {
    const url = `${this.baseUrl}/login`;
    return this.http.post<User>(url, user, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }

  register(user: { username: string, password: string }): Observable<User> {
    const url = `${this.baseUrl}/register`;
    return this.http.post<User>(url, user, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }
}
