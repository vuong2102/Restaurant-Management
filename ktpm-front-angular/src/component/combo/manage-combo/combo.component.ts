import { Component, OnInit } from '@angular/core';
import { ComboService } from '../../../service/comboService/combo.service';
import { Combo } from 'src/model/Combo';
import { Router } from '@angular/router';

@Component({
  selector: 'app-combo',
  templateUrl: './combo.component.html',
  styleUrls: ['./combo.component.css'],
})
export class ComboComponent implements OnInit {
  allCombo: Combo[] = [];
  searchTerm: any;

  constructor(private comboService: ComboService,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.getAllCombo();
  }
  getAllCombo() {
    this.comboService.getAllCombo().subscribe((res: Combo[]) => {
      this.allCombo = res;
    });
  }

  addCombo() {
    throw new Error('Method not implemented.');
  }
  deleteCombo(arg0: any) {
    throw new Error('Method not implemented.');
  }
  detailCombo(id: number) {
    this.router.navigate(['combo', id]);
  }
}
