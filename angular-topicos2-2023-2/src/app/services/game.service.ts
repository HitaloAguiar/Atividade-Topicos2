import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Game } from '../models/game.model';

@Injectable({
  providedIn: 'root'
})
export class GameService {

  private baseURL: string = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getGames(): Observable<Game[]> {
    return this.http.get<Game[]>(`${this.baseURL}/games`);
  }

  salvar(game: Game): Observable<Game> {
    return this.http.post<Game>(`${this.baseURL}/games`, game);
  }
}
