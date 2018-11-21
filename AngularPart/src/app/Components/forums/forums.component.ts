import {Component, OnInit} from '@angular/core';
import {ForumService} from '../../Services/forum.service';

@Component({
  selector: 'app-forums',
  templateUrl: './forums.component.html',
  styleUrls: ['./forums.component.css',
    '../../../../node_modules/source-sans-pro/source-sans-pro.css',
    'styles/BBOOTS/theme/RobotoCondensed.css',
    'styles/BBOOTS/theme/stylesheet.css',
    'styles/BBOOTS/theme/basics.min.css',
    'styles/BBOOTS/theme/custom.css?assets_version=26',
    '../../../../node_modules/bootstrap/dist/css/bootstrap.css']
})
export class ForumsComponent implements OnInit {
forums: any[];
  constructor(private forumservice: ForumService) {}

  ngOnInit() {
    this.forumservice.getAll().subscribe(gottenforums => {
        console.log(gottenforums);
        this.forums = gottenforums;
      }
    );
  }

}
